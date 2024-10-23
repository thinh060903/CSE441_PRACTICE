package vn.edu.tlu.masv;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("getLoaiMon.php")
    Call<List<LoaiMon>> getLoaiMon();

    @GET("getMon.php")
    Call<List<Mon>> getMon(@Query("loaimon") int loaiMonId);
}
