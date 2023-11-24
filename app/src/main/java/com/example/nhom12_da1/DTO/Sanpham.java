package com.example.nhom12_da1.DTO;



import com.example.nhom12_da1.R;

import java.io.Serializable;
import java.util.ArrayList;

public class Sanpham implements Serializable {
    private int id;
    private String tenSanPham, moTa, giaSanPham, loaiSanPham;
    private int image;

    public Sanpham() {
    }

    public Sanpham(int id, String tenSanPham, String moTa, String giaSanPham, String loaiSanPham, int image) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.giaSanPham = giaSanPham;
        this.loaiSanPham = loaiSanPham;
        this.image = image;
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGiaSanPham() {
        return giaSanPham;
    }

    public void setGiaSanPham(String giaSanPham) {
        this.giaSanPham = giaSanPham;
    }

    public String getLoaiSanPham() {
        return loaiSanPham;
    }

    public void setLoaiSanPham(String loaiSanPham) {
        this.loaiSanPham = loaiSanPham;
    }

    public ArrayList getAll() {
        ArrayList<Sanpham> list = new ArrayList<>();
        list.add(new Sanpham(1, "Nike Air Force 1 '07 EasyOnG", "Thông tin sản phẩm Nike Air Force 1 '07 EasyOn:\n"+
                "- Nhanh hơn 1, 2, 3—giày vòng ban đầu cho phép bạn bước vào và bắt đầu.\n"+
                "-  Hệ thống nhập EasyOn mang đến cho bạn trải nghiệm rảnh tay, \n"+
                "- trong khi da sắc nét mang lại màu sắc sạch sẽ nhất để mang lại khả năng đeo tối ưu.\n"+
                "- Vâng, đó là tất cả những gì bạn yêu thích và sau đó là một số.", "590000", "ao", R.drawable.anh1));
        list.add(new Sanpham(2, "Nike Court Vision Low Next Nature\n","Phong cách: DH2987-101\n"+
                "Thành phần: 100% poly\n"+
                "- Yêu thích vẻ ngoài cổ điển của bóng rổ thập niên 80 nhưng lại quan tâm đến văn hóa nhịp độ nhanh của trò chơi ngày nay","1480000","ao", R.drawable.anh2));
        list.add(new Sanpham(3, "Air Jordan 1 Low SE","Phong cách: DZ4130-201\n"+
                "chất liệu cao cấp và được trang trí bằng những điểm nhấn tinh tế (kiểm tra Swoosh in hình con voi và Jumpman vàng)\n"+
                "- Màu sắc mới và kết cấu mới mẻ mang đến cho bạn một chiếc AJ1 cập nhật mà không làm mất đi vẻ ngoài tuyệt vời và cảm giác quen thuộc\n"+
                "- Màu sắc hiển thị: Gai/Trắng/Đen/Tân Anh nhạt","1500000","ao", R.drawable.anh3));
        list.add(new Sanpham(4, "Nike Air Max 270","Phong cách: AH8050-100\n"+
                "Phong cách sống đầu tiên của Nike Air Max mang đến cho bạn phong cách, sự thoải mái và phong thái ấn tượng trong Nike Air Max 270. \n"+
                "- Thiết kế lấy cảm hứng từ các biểu tượng Air Max, thể hiện sự đổi mới lớn nhất của Nike với cửa sổ lớn và nhiều màu sắc tươi mới.\n"+
                "- Màu sắc hiển thị: Trắng/Trắng/Đen","1600000","ao", R.drawable.anh4));
        list.add(new Sanpham(5, "Sân vận động Jordan 90","Phong cách: DX4397-104\n"+
                "Sự thoải mái là quan trọng nhất, nhưng điều đó không có nghĩa là bạn phải hy sinh phong cách. Lấy cảm hứng thiết kế từ AJ1 và AJ5, Stadium 90\n"+
                "- Thân thiện\n"+
                "- Thấm hút thoát ẩm\n"+
                "- Mềm mại\n"+
                "- Kiểm soát mùi\n"+
                "- Độ bền\n"+
                "+ Phong cách\n"+
                "+ Phần trên được làm từ da và vải dệt thoáng mát\n"+
                "+ đồng thời đệm Nike Air ở đế giúp mỗi bước đi của bạn luôn nhẹ nhàng và êm ái.\n"+
                "+ Màu sắc hiển thị: Trắng/Đen/Cánh buồm/Game Royal","1480000","ao", R.drawable.anh5));
        list.add(new Sanpham(6, "Air Max 90 LTR","Phong cách: CZ5594-001\n"+
                "Nike Air Max 90 LTR vẫn đúng với nguồn gốc chạy OG của nó với đế ngoài Waffle mang tính biểu tượng\n"+
                "- Thân thiện\n"+
                "- Thoáng khí\n"+
                "- Mềm mại\n"+
                "- Kiểm soát mùi\n"+
                "- Phong Cách\n"+
                "+ Có đệm khí\n"+
                "+ Lớp phủ da mịn được khâu và các tấm TPU có màu sắc cổ điển.\n"+
                "+ Thân giày đơn sắc mang lại nhiều lựa chọn kiểu dáng linh hoạt trong khi đệm Max Air mang lại sự thoải mái\n"+
                "+ Màu sắc hiển thị: Đen/Đen/Đen","1850000","ao", R.drawable.anh6));
        list.add(new Sanpham(7, "Nike Air Max 97","Phong cách: 921826-101\n"+
                "Với thiết kế gợn sóng nguyên bản lấy cảm hứng từ tàu cao tốc Nhật Bản, Nike Air Max 97 cho phép bạn đẩy nhanh phong cách của mình về phía trước.\n"+
                "- Lấy bộ Nike Air dài đầy đủ mang tính cách mạng đã làm rung chuyển thế giới chạy bộ và thêm màu sắc tươi mới\n"+
                "- Màu sắc hiển thị: Trắng/Đen/Xám sói","2550000","ao", R.drawable.anh7));
        list.add(new Sanpham(8, "Jumpman Hai Trey","Phong cách: DO1925-003\n"+
                "Giống như \"Two Trey\" trên biển số xe của MJ, hãy cho biết sự hiện diện của bạn. \n"+
                "- Thế hệ Jordan mới này kỷ niệm thời gian của Mike ở Chicago, hoàn chỉnh với mũ giày bằng da chất lượng cao và đế có đệm khí.\n"+
                "- Được tạo ra nhằm tôn vinh phong cách thi đấu trên sân trong những năm anh vô địch, thiết kế đế giữa của Two Trey lấy cảm hứng từ cả AJ11 và AJ12.\n"+
                "- Màu sắc hiển thị: Đen/Đen/Trắng/Đỏ đại học","2550000","ao", R.drawable.anh8));
        list.add(new Sanpham(9, "Nike Air Max Cirro","Phong cách: DC1460-002\n"+
                "Cho dù bạn đang tập gym hay đi đến cửa hàng, chúng tôi đã tạo ra một sự kết hợp hoàn hảo mang lại phong cách nhanh chóng và sự thoải\n"+
                "+ Không khí lớn, có thể nhìn thấy ở gót chân được kết hợp với phần đệm chân bằng xốp thoải mái để tạo ấn tượng về sự thoải mái.\n"+
                "+ Màu sắc hiển thị: Đen/Đỏ đại học/Đỏ đại học","2985000","ao", R.drawable.anh9));
        list.add(new Sanpham(10, "Nike Asuna 2 ","Phong cách: DX6865-002\n"+
                "Bạn muốn chuyển đổi dễ dàng giữa công việc và vui chơi? Được thiết kế để mang lại cảm giác thoải mái cả ngày\n"+
                "- những chiếc cầu trượt sang trọng này sử dụng kiểu gai lốp chắc chắn để tạo lực kéo trên nhiều bề mặt khác nhau\n"+
                "- Phần đóng giày mới và cải tiến ôm vừa phải đầu bàn chân của bạn. Bước vào, đóng cửa lại và đi tiếp.\n"+
                "- Màu sắc hiển thị: Đen/Cánh buồm","2850000","ao", R.drawable.anh10));
        list.add(new Sanpham(11, "Air Jordan 1 Giữa SE","Phong cách: FJ4923-008\n"+
                "Thêm một số màu sắc cổ điển và trông thật tuyệt khi làm điều đó.\n"+
                "- Đôi giày này có da nubuck và da lộn ở phía trên mang lại cảm giác sang trọng.\n"+
                "- Đế Nike Air giúp mỗi bước đi của bạn luôn nhẹ nhàng… à, không khí.\n"+
                "- Màu sắc hiển thị: Đen/Đỏ hồng y/Trắng/Cam sống động","3845000","quan", R.drawable.anh11));
        list.add(new Sanpham(12, "Air Jordan 1 Giữa SE","Phong cách: DZ4129-102\n"+
                "Màu sắc mới và kết cấu mới mẻ mang đến cho bạn một chiếc AJ1 cập nhật mà không làm mất đi vẻ ngoài tuyệt vời và cảm giác quen thuộc.\n"+
                "- Đôi giày được yêu thích nhất mọi thời đại này được làm từ chất liệu cao cấp và được trang trí bằng các điểm nhấn tinh tế\n"+
                "- Mang đến cho bạn một đôi giày thể thao chủ yếu với phong cách hiện đại.\n"+
                "- Chữ ® có thể xuất hiện một hoặc hai lần trên lưỡi giày và/hoặc lót giày do Nike thực hiện thay đổi.\n"+
                "-Về mặt này, sản phẩm bạn mua có thể trông khác với sản phẩm được mô tả trên Nike.com hoặc NikeApp.\n"+
                "-Màu sắc hiển thị: Nâu quặng nhẹ/Trắng/Tân Anh nhạt/Vàng kim loại","3493000","quan", R.drawable.anh12));
        list.add(new Sanpham(13, "Nike Invincible 3","- Phong cách: DR2615-002\n"+
                "Với khả năng giảm chấn tối đa để hỗ trợ mỗi dặm, Invincible 3 có mức độ thoải mái cao nhất dưới chân\n"+
                "- Bọt ZoomX sang trọng và nảy giúp bạn luôn ổn định và tươi mới.\n"+
                "- Nói cách khác—bạn sẽ cảm thấy dễ chịu cả ngày, bất kể bạn đang làm gì\n"+
                "- Nó có mọi thứ bạn cần để bạn có thể đi theo con đường ưa thích của mình\n"+
                "- NIKE ZOOM X hoặc NIKE INVINCIBLE RUN 3 có thể xuất hiện ở gót chân do Nike thực hiện thay đổi.\n"+
                "- Về mặt này, sản phẩm bạn mua có thể trông khác với sản phẩm được mô tả trên Nike.com/NikeApp\n"+
                "- Không có sự khác biệt về hiệu suất hoặc chức năng.\n"+
                "- Màu sắc hiển thị: Đen/Trắng","3085000","quan", R.drawable.anh13));
        list.add(new Sanpham(14, "Nike Victori One Next Nature","Phong cách: DM8598-002\n"+
                "Từ bãi biển đến khán đài, Nike Victori One Next Nature là đôi giày trượt cần phải có cho những ngày nắng\n"+
                "- Nhẹ và dễ mang theo (hoặc mang theo cho kỳ nghỉ của bạn), lớp bọt mềm mại, đàn hồi giúp bạn dễ dàng thư giãn.\n"+
                "- Màu sắc hiển thị: Đen/Đen/Phantom","4250000","quan", R.drawable.anh14));
        list.add(new Sanpham(15, "Nike Air Max Pulse","Phong cách: DR0453-002\n"+
                "Air Max Pulse lấy cảm hứng từ nền âm nhạc London, mang đến nét hầm hố cho dòng Air Max mang tính biểu tượng.\n"+
                "- Đế giữa được bọc bằng vải dệt và các điểm nhấn hút chân không giúp đôi giày trông mới mẻ và sạch sẽ\n"+
                "- lấy cảm hứng từ nền âm nhạc London mang đến cho bạn vẻ ngoài nổi bật. \n"+
                "- Đệm khí nén theo điểm—được cải tiến từ Air Max 270 vô cùng sang trọng\n"+
                "- Màu sắc hiển thị: Đen/Xám khói nhạt/Xanh Laser/Xanh Laser","2425000","quan", R.drawable.anh15));

        return list;
    }
}
