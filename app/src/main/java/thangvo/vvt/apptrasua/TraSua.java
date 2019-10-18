package thangvo.vvt.apptrasua;

public class TraSua {
    private int Hinh;
    private String ten , chitet, gia;

    public TraSua(int hinh, String ten, String chitet, String gia) {
        Hinh = hinh;
        this.ten = ten;
        this.chitet = chitet;
        this.gia = gia;
    }

    public int getHinh() {
        return Hinh;
    }

    public void setHinh(int hinh) {
        Hinh = hinh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getChitet() {
        return chitet;
    }

    public void setChitet(String chitet) {
        this.chitet = chitet;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }
}
