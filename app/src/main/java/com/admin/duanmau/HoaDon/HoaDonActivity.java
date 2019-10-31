package com.admin.duanmau.HoaDon;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.admin.duanmau.Adapter.BillAdapter;
import com.admin.duanmau.Base.BaseActivity;
import com.admin.duanmau.DAO.InvoiceDAO;
import com.admin.duanmau.Model.Invoice;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class HoaDonActivity extends BaseActivity {

    private EditText edtMaHD;
    private EditText edtNgayMuaHD;
    private Button btnNgayMua;
    private Button btnThemHoaDon, btnChiTietHoaDon;
    private RecyclerView rvHoaDon;
    private List<Invoice> list;
    private BillAdapter adapter;
    private InvoiceDAO invoiceDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don);

        initView();

        btnNgayMua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                final int month = calendar.get(Calendar.MONTH);
                final int day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(HoaDonActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        int thang = monthOfYear + 1;
                        String month = String.valueOf(thang);
                        if(thang < 10){
                            month = "0"+String.valueOf(thang);
                        }
                        String day = String.valueOf(dayOfMonth);
                        if(dayOfMonth < 10){
                            day = "0"+String.valueOf(dayOfMonth);
                        }

                        edtNgayMuaHD.setText(year+"-"+month+"-"+day );
                    }
                }, year, month, day);

                datePickerDialog.show();

            }
        });

        btnThemHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });

        btnChiTietHoaDon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeClass(HoaDonChiTietActivity.class);
            }
        });

    }

    private void validation(){
        String mahoadon = edtMaHD.getText().toString();
        String ngaymua = edtNgayMuaHD.getText().toString();
         if(ngaymua.equals("yyyy-MM-dd")){
            showMessage("Vui lòng nhập ngày mua");
        }
        else if(invoiceDAO.insertInvoice(new Invoice(mahoadon,ngaymua)) > 0){
            showMessage("Thêm hóa đơn thành công");
            this.clearAllEditText();
            this.recreate();
        }
        else if(invoiceDAO.insertInvoice(new Invoice(mahoadon,ngaymua)) <= 0){
            showMessage("Thêm hóa đơn thất bại do trùng mã hóa đơn");
        }
    }

    public void removeUser(String username, int position){
        invoiceDAO.removeInvoice(username);
        list.remove(position);
        adapter.notifyDataSetChanged();
        showMessage("Xóa hóa đơn thành công");
    }

    private void clearAllEditText(){
        edtMaHD.setText("");
        edtNgayMuaHD.setText("yyyy-MM-dd");
    }

    public void initView(){
        edtMaHD = (EditText) findViewById(R.id.edtMaHD);
        edtNgayMuaHD = (EditText) findViewById(R.id.edtNgayMuaHD);
        btnNgayMua = (Button) findViewById(R.id.btnNgayMua);
        btnChiTietHoaDon = findViewById(R.id.btnChiTietHoaDon);
        btnThemHoaDon = (Button) findViewById(R.id.btnThemHoaDon);
        rvHoaDon = (RecyclerView) findViewById(R.id.rvHoaDon);
        invoiceDAO = new InvoiceDAO(this);
        list = new ArrayList<>();
        list = invoiceDAO.getAllInvoice();
        adapter = new BillAdapter(this,list);

        rvHoaDon.setLayoutManager(new LinearLayoutManager(this));
        rvHoaDon.setAdapter(adapter);

    }

}
