public class ManajemenData {

    //sorting asc pake bubble sort
    public void urutkanBeratAscending(LinkedListBarang list) {
        if (list.head == null) {
            System.out.println("Data kosong, tidak bisa diurutkan.");
            return;
        }

        boolean swapped;
        NodeBarang ptr1;
        NodeBarang lptr = null;

        do {
            swapped = false;
            ptr1 = list.head;

            while (ptr1.next != lptr) {
                if (ptr1.berat > ptr1.next.berat) {
                    tukarData(ptr1, ptr1.next);
                    swapped = true;
                }
                ptr1 = ptr1.next;
            }
            lptr = ptr1;
        } while (swapped);

        System.out.println("\n[SUKSES] Data telah diurutkan berdasarkan BERAT (Terkecil ke Terbesar).");
        list.tampilBarang(); 
    }

    private void tukarData(NodeBarang a, NodeBarang b) {
        String tId = a.idBarang;
        String tNama = a.namaBarang;
        String tKat = a.Kategori;
        String tPen = a.NamaPenitip;
        String tTgl = a.tglTitip;
        Double tBerat = a.berat;

        a.idBarang = b.idBarang;
        a.namaBarang = b.namaBarang;
        a.Kategori = b.Kategori;
        a.NamaPenitip = b.NamaPenitip;
        a.tglTitip = b.tglTitip;
        a.berat = b.berat;

        b.idBarang = tId;
        b.namaBarang = tNama;
        b.Kategori = tKat;
        b.NamaPenitip = tPen;
        b.tglTitip = tTgl;
        b.berat = tBerat;
    }

    //searching
    public void cariData(LinkedListBarang list, String keyword) {
        System.out.println("\n=== HASIL PENCARIAN UNTUK: \"" + keyword + "\" ===");
        
        NodeBarang temp = list.head;
        boolean ditemukan = false;
        int count = 0;

        System.out.println("+-------+--------------------------+----------------------+--------------------+------------+");
        System.out.printf("| %-5s | %-24s | %-20s | %-18s | %-10s |\n", 
                "ID", "NAMA BARANG", "KATEGORI", "PENITIP", "BERAT");
        System.out.println("+-------+--------------------------+----------------------+--------------------+------------+");

        while (temp != null) {
            boolean matchId = temp.idBarang.equalsIgnoreCase(keyword);
            boolean matchPenitip = temp.NamaPenitip.toLowerCase().contains(keyword.toLowerCase());

            if (matchId || matchPenitip) {
                System.out.printf("| %-5s | %-24s | %-20s | %-18s | %7.2f kg |\n", 
                    temp.idBarang, 
                    potongNama(temp.namaBarang, 24), 
                    temp.Kategori, 
                    potongNama(temp.NamaPenitip, 18), 
                    temp.berat);
                ditemukan = true;
                count++;
            }
            temp = temp.next;
        }
        System.out.println("+-------+--------------------------+----------------------+--------------------+------------+");

        if (ditemukan) {
            System.out.println("Ditemukan " + count + " data yang cocok.");
        } else {
            System.out.println("Maaf, data tidak ditemukan.");
        }
    }

    private String potongNama(String nama, int max) {
        if (nama.length() > max) return nama.substring(0, max - 3) + "...";
        return nama;
    }
}