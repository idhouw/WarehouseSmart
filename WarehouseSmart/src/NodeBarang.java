public class NodeBarang {
    String idBarang;
    String namaBarang;
    String Kategori;
    String NamaPenitip;
    String tglTitip;
    int berat;
    NodeBarang next;   // untuk LinkedList
    NodeBarang left;   // untuk Tree (BST)
    NodeBarang right;  // untuk Tree (BST)

    public NodeBarang(String idBarang, String namaBarang, String Kategori, String NamaPenitip, String tglTitip, int berat) {
        this.idBarang = idBarang;
        this.namaBarang = namaBarang;
        this.Kategori = Kategori;
        this.NamaPenitip = NamaPenitip;
        this.tglTitip = tglTitip;
        this.berat = berat;
        this.next = null;
        this.left = null;
        this.right = null;
    }
}

