public class TreeKategori {

    private class NodeLemari {
        String namaKategori;
        int totalBerat;
        NodeBarang headRak; 
        NodeLemari left, right;

        NodeLemari(String kategori) {
            this.namaKategori = kategori;
            this.totalBerat = 0;
            this.headRak = null;
            this.left = null;
            this.right = null;
        }
    }

    private NodeLemari root;

    public void simpanKeGudang(NodeBarang barangAsli) {
        NodeBarang salinan = new NodeBarang(
            barangAsli.idBarang, barangAsli.namaBarang, barangAsli.Kategori,
            barangAsli.NamaPenitip, barangAsli.tglTitip, barangAsli.berat
        );
        root = insertRecursive(root, salinan);
    }

    private NodeLemari insertRecursive(NodeLemari currentLemari, NodeBarang barang) {
        if (currentLemari == null) {
            NodeLemari baru = new NodeLemari(barang.Kategori);
            masukkanKeRak(baru, barang);
            return baru;
        }
        if (barang.Kategori.equalsIgnoreCase(currentLemari.namaKategori)) {
            masukkanKeRak(currentLemari, barang);
            return currentLemari;
        }
        if (barang.Kategori.compareToIgnoreCase(currentLemari.namaKategori) < 0) {
            currentLemari.left = insertRecursive(currentLemari.left, barang);
        } else {
            currentLemari.right = insertRecursive(currentLemari.right, barang);
        }
        return currentLemari;
    }

    private void masukkanKeRak(NodeLemari lemari, NodeBarang barang) {
        lemari.totalBerat += barang.berat;
        if (lemari.headRak == null) {
            lemari.headRak = barang;
        } else {
            NodeBarang temp = lemari.headRak;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = barang;
        }
    }

    public void lihatIsiGudang() {
        System.out.println("\n=== [4] DENAH GUDANG & ISI LEMARI ===");
        if (root == null) {
            System.out.println("Gudang Kosong.");
            return;
        }
        inorderView(root);
    }

    private void inorderView(NodeLemari lemari) {
        if (lemari != null) {
            inorderView(lemari.left);

            // TAMPILAN LEMARI (Header)
            System.out.println("=================================================");
            System.out.printf("| LEMARI: %-20s (Total: %4d kg) |\n", 
                    lemari.namaKategori.toUpperCase(), lemari.totalBerat);
            System.out.println("=================================================");
            
            // TAMPILAN ISI RAK (Tabel dalam Lemari)
            System.out.println("| ID    | Nama Barang              | Berat      |");
            System.out.println("|-------|--------------------------|------------|");

            NodeBarang b = lemari.headRak;
            while (b != null) {
                System.out.printf("| %-5s | %-24s | %7.2f kg |\n", 
                        b.idBarang, 
                        potongNama(b.namaBarang, 24), 
                        b.berat);
                b = b.next;
            }
            System.out.println("+-----------------------------------------------+");

            inorderView(lemari.right);
        }
    }

    private String potongNama(String nama, int max) {
        if (nama.length() > max) return nama.substring(0, max - 3) + "...";
        return nama;
    }
}