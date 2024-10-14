package com.example.ex06;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText edtten, editCMND, editBosung;
    CheckBox chkdocbao, chkdocsach, chkdoccode;
    Button btnsend;
    RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần từ giao diện XML
        edtten = findViewById(R.id.edtten);
        editCMND = findViewById(R.id.edtcmnd);
        editBosung = findViewById(R.id.edtbosung);
        chkdocbao = findViewById(R.id.chkdocbao);
        chkdocsach = findViewById(R.id.chkdocsach);
        chkdoccode = findViewById(R.id.chkcode);
        btnsend = findViewById(R.id.btnsend);
        group = findViewById(R.id.idgroup);

        // Xử lý sự kiện khi nhấn nút "Gửi thông tin"
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                doShowInformation();
            }
        });
    }

    // Hàm hiển thị thông tin cá nhân
    public void doShowInformation() {
        // Kiểm tra tên hợp lệ
        String ten = edtten.getText().toString().trim();
        if (ten.length() < 3) {
            edtten.requestFocus();
            edtten.selectAll();
            Toast.makeText(this, "Tên phải có ít nhất 3 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        // Kiểm tra CMND hợp lệ
        String cmnd = editCMND.getText().toString().trim();
        if (cmnd.length() != 9) {
            editCMND.requestFocus();
            editCMND.selectAll();
            Toast.makeText(this, "CMND phải đúng 9 ký tự", Toast.LENGTH_LONG).show();
            return;
        }

        // Kiểm tra bằng cấp
        String bang = "";
        int id = group.getCheckedRadioButtonId(); // Trả về ID của radio button được chọn
        if (id == -1) {
            Toast.makeText(this, "Phải chọn bằng cấp", Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad = findViewById(id);
        bang = rad.getText().toString(); // Lấy văn bản của radio button được chọn

        // Kiểm tra sở thích
        StringBuilder sothich = new StringBuilder();
        if (chkdocbao.isChecked()) {
            sothich.append(chkdocbao.getText()).append(" - ");
        }
        if (chkdocsach.isChecked()) {
            sothich.append(chkdocsach.getText()).append(" - ");
        }
        if (chkdoccode.isChecked()) {
            sothich.append(chkdoccode.getText());
        }

        // Nếu không có sở thích nào được chọn, thông báo lỗi
        if (sothich.length() == 0) {
            Toast.makeText(this, "Phải chọn ít nhất một sở thích", Toast.LENGTH_LONG).show();
            return;
        }

        // Lấy thông tin bổ sung (có thể rỗng)
        String bosung = editBosung.getText().toString().trim();

        // Tạo và hiển thị AlertDialog với thông tin cá nhân
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông tin cá nhân");

        // Nội dung của thông báo
        String msg = ten + "\n" + cmnd + "\n" + bang + "\n" + sothich.toString() + "\n";
        msg += "—————————–\nThông tin bổ sung:\n" + bosung + "\n—————————–";
        builder.setMessage(msg);

        // Nút đóng trong thông báo
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Hiển thị AlertDialog
        builder.create().show();
    }

    // Xử lý khi nhấn nút Back của thiết bị
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exit?");
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Thoát ứng dụng
            }
        });
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel(); // Đóng hộp thoại
            }
        });
        b.create().show(); // Hiển thị hộp thoại xác nhận
    }
}
