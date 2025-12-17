public class LinkedListBarang {
    NodeBarang head;

    public void tambahBarang(String idBarang, String namaBarang, String kategori,
                             String namaPenitip, String tglTitip, Double berat) {

        NodeBarang baru = new NodeBarang(idBarang, namaBarang, kategori, namaPenitip, tglTitip, berat);

        if (head == null) {
            head = baru;
        } else {
            NodeBarang temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = baru;
        }
    }

    public void hapusBarang(String idBarang) {
        if (head == null) {
            System.out.println("Data kosong, tidak ada barang yang dihapus.");
            return;
        }

        System.out.println("\n==============================================");
        System.out.println("        MENGAPUS BARANG DARI SISTEM");
        System.out.println("==============================================");
        
        if (head.idBarang.equalsIgnoreCase(idBarang)) {
            head = head.next;
            System.out.println("Barang dengan ID " + idBarang + " berhasil dihapus.");
            return;
        }

        NodeBarang temp = head;
        while (temp.next != null && !temp.next.idBarang.equalsIgnoreCase(idBarang)) {
            temp = temp.next;
        }

        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Barang dengan ID " + idBarang + " berhasil dihapus.");
        } else {
            System.out.println("Barang dengan ID " + idBarang + " tidak ditemukan.");
        }
    }

    public void tampilBarang() {
        if (head == null) {
            System.out.println("Data kosong.");
            return;
        }

        System.out.println("\n=== [1] DAFTAR LENGKAP SEMUA BARANG ===");
        System.out.println("+-------+--------------------------+----------------------+-------------+------------+");
        System.out.printf("| %-5s | %-24s | %-20s | %-11s | %-10s |\n", 
                "ID", "NAMA BARANG", "KATEGORI", "TGL TITIP", "BERAT");
        System.out.println("+-------+--------------------------+----------------------+-------------+------------+");

        NodeBarang temp = head;
        while (temp != null) {
            System.out.printf("| %-5s | %-24s | %-20s | %-11s | %7.2f kg |\n", 
                    temp.idBarang, 
                    potongNama(temp.namaBarang, 24),
                    temp.Kategori, 
                    temp.tglTitip, 
                    temp.berat);
            temp = temp.next;
        }
        System.out.println("+-------+--------------------------+----------------------+-------------+------------+");
    }

    private String potongNama(String nama, int max) {
        if (nama.length() > max) {
            return nama.substring(0, max - 3) + "...";
        }
        return nama;
    }
}