public class NodeBarang {
    String idBarang;
    String namaBarang;
    String Kategori;
    String NamaPenitip;
    String tglTitip;
    Double berat;
    
    NodeBarang next; 
    public NodeBarang(String idBarang, String namaBarang, String Kategori, String NamaPenitip, String tglTitip, Double berat) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.Kategori = Kategori;
        this.NamaPenitip = NamaPenitip;
        this.tglTitip = tglTitip;
        this.berat = berat;
        this.next = null;
    }
}