package com.admin.duanmau.HoaDon;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.admin.duanmau.Adapter.BillDetailAdapter;
import com.admin.duanmau.Base.BaseActivity;
import com.admin.duanmau.DAO.InvoiceDetailDAO;
import com.admin.duanmau.Model.BillDetail;
import com.admin.duanmau.Model.InvoiceDetail;
import com.admin.duanmau.R;

import java.util.ArrayList;
import java.util.List;

public class HoaDonChiTietActivity extends BaseActivity {

    private EditText edtHDCTMaSach;
    private EditText edtHDCTMaHD;
    private EditText editText3;
    private Button btnThemHDCT;
    private RecyclerView rvHoaDonChiTiet;
    private InvoiceDetailDAO invoiceDetailDAO;
    private BillDetailAdapter adapter;
    private List<BillDetail> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hoa_don_chi_tiet);

        initView();

        btnThemHDCT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });

        rvHoaDonChiTiet.setLayoutManager(new LinearLayoutManager(this));
        rvHoaDonChiTiet.setAdapter(adapter);

    }

    private void validation(){

        try{
            String masach = edtHDCTMaSach.getText().toString();
            String mahoadon = edtHDCTMaHD.getText().toString();
            int soluongmua = Integer.parseInt(editText3.getText().toString());

            if(masach.isEmpty()){
                showMessage("Vui lòng không để trống mã sách");
            }
            else if(mahoadon.isEmpty()){
                showMessage("Vui lòng không để trống mã hóa đơn");
            }
            else if(invoiceDetailDAO.checkMasachHoaDon(masach,"",1) == false){
                showMessage("Mã sách không có trong danh sách");
            }
            else if(invoiceDetailDAO.checkMasachHoaDon("",mahoadon,2) == false){
                showMessage("Mã hóa đơn không có trong danh sách");
            }
            else if(invoiceDetailDAO.insertInvoiceDetail(new InvoiceDetail(masach,mahoadon,soluongmua)) > 0){
                showMessage("Thêm hóa đơn chi tiết thành công");
                clearAllEditText();
                this.recreate();
            }
            else if(invoiceDetailDAO.insertInvoiceDetail(new InvoiceDetail(masach,mahoadon,soluongmua)) <= 0){
                showMessage("Thêm hóa đơn chi tiết thất bại");
            }
        }catch (NumberFormatException e){
            showMessage("Vui lòng nhập số lượng mua là số");
        }

    }

    private void clearAllEditText(){
        editText3.setText("");
        edtHDCTMaSach.setText("");
        edtHDCTMaHD.setText("");
    }

    private void initView(){
        edtHDCTMaSach = (EditText) findViewById(R.id.edtHDCTMaSach);
        edtHDCTMaHD = (EditText) findViewById(R.id.edtHDCTMaHD);
        editText3 = (EditText) findViewById(R.id.editText3);
        btnThemHDCT = (Button) findViewById(R.id.btnThemHDCT);
        rvHoaDonChiTiet = (RecyclerView) findViewById(R.id.rvHoaDonChiTiet);

        invoiceDetailDAO = new InvoiceDetailDAO(this);
        list = new ArrayList<>();
        list = invoiceDetailDAO.getAllInvoice();
        adapter = new BillDetailAdapter(this,list);

    }

}
