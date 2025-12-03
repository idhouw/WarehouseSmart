public class LinkedListBarang {
    NodeBarang head;

    // Tambah Barang
    public void tambahBarang(String idBarang, String namaBarang, String kategori,
                             String namaPenitip, String tglTitip, int berat) {

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

        System.out.println("Barang berhasil ditambahkan!");
    }

    // Tampil Barang
    public void tampilBarang() {
        if (head == null) {
            System.out.println("Tidak ada barang tersimpan.");
            return;
        }

        NodeBarang temp = head;
        System.out.println("\n=== Daftar Barang Dititipkan ===");
        while (temp != null) {
            System.out.println("----------------------------------------");
            System.out.println("ID Barang     : " + temp.idBarang);
            System.out.println("Nama Barang   : " + temp.namaBarang);
            System.out.println("Kategori      : " + temp.Kategori);
            System.out.println("Nama Penitip  : " + temp.NamaPenitip);
            System.out.println("Tanggal Titip : " + temp.tglTitip);
            System.out.println("Berat Barang  : " + temp.berat + " kg");
            temp = temp.next;
        }
        System.out.println("----------------------------------------");
    }

    // Cari Barang berdasarkan ID
    public NodeBarang cariBarangById(String idBarang) {
        NodeBarang temp = head;

        while (temp != null) {
            if (temp.idBarang.equalsIgnoreCase(idBarang)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // Hapus barang berdasarkan ID
    public boolean hapusBarang(String idBarang) {
        if (head == null) return false;

        if (head.idBarang.equals(idBarang)) {
            head = head.next;
            return true;
        }

        NodeBarang temp = head;
        while (temp.next != null) {
            if (temp.next.idBarang.equals(idBarang)) {
                temp.next = temp.next.next;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    // Update barang
    public boolean updateBarang(String idBarang, String namaBaru, String kategoriBaru,
                                String penitipBaru, String tglBaru, int beratBaru) {

        NodeBarang barang = cariBarangById(idBarang);

        if (barang == null) return false;

        barang.namaBarang = namaBaru;
        barang.Kategori = kategoriBaru;
        barang.NamaPenitip = penitipBaru;
        barang.tglTitip = tglBaru;
        barang.berat = beratBaru;

        return true;
    }

    // Hitung total barang
    public int hitungTotalBarang() {
        int count = 0;
        NodeBarang temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}


