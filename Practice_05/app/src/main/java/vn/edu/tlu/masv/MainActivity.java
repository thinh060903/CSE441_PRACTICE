package vn.edu.tlu.masv;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private DrinkAdapter drinkAdapter;
    private Retrofit retrofit;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Khởi tạo RecyclerView và Adapter
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Khởi tạo Retrofit để kết nối với API PHP
        retrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.2.2/tlucoffee/")  // URL kết nối đến XAMPP
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Khởi tạo ApiService từ Retrofit
        apiService = retrofit.create(ApiService.class);

        // Gọi API để lấy danh sách loại món
        fetchLoaiMonData();
    }

    // Hàm gọi API để lấy danh sách loại món từ PHP
    private void fetchLoaiMonData() {
        apiService.getLoaiMon().enqueue(new Callback<List<LoaiMon>>() {
            @Override
            public void onResponse(Call<List<LoaiMon>> call, Response<List<LoaiMon>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<LoaiMon> loaiMon = response.body();
                    Log.d("API Response", loaiMon.toString());  // Log dữ liệu trả về để kiểm tra

                    // Cập nhật RecyclerView với danh sách loại món
                    drinkAdapter = new DrinkAdapter(loaiMon);
                    recyclerView.setAdapter(drinkAdapter);

                } else {
                    // Khi phản hồi không thành công
                    Log.e("API Error", "Response error: " + response.message());
                    Toast.makeText(MainActivity.this, "Không thể tải dữ liệu", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<LoaiMon>> call, Throwable t) {
                // Khi kết nối thất bại
                Log.e("API Error", "Connection failed: " + t.getMessage());
                Toast.makeText(MainActivity.this, "Lỗi kết nối đến API", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
