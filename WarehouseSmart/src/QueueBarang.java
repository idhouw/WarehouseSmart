public class QueueBarang {

    private class ElemenQueue {
        NodeBarang data;
        ElemenQueue next;

        ElemenQueue(NodeBarang data) {
            this.data = data;
            this.next = null;
        }
    }

    private ElemenQueue front;
    private ElemenQueue rear;
    
    public void enqueue(NodeBarang barang) {
        ElemenQueue baru = new ElemenQueue(barang);
        if (front == null) {
            front = baru;
            rear = baru;
        } else {
            rear.next = baru;
            rear = baru;
        }
    }

    public void tampilAntrian() {
        System.out.println("\n=== [2] MONITORING ANTRIAN MASUK ===");
        if (front == null) {
            System.out.println(" [ Antrian Kosong ] ");
            return;
        }

        System.out.println("+-----+-------+--------------------------+----------------------+");
        System.out.printf("| %-3s | %-5s | %-24s | %-20s |\n", "NO", "ID", "NAMA BARANG", "KATEGORI");
        System.out.println("+-----+-------+--------------------------+----------------------+");

        ElemenQueue temp = front;
        int no = 1;
        while (temp != null) {
            System.out.printf("| %-3d | %-5s | %-24s | %-20s |\n", 
                    no++, 
                    temp.data.idBarang, 
                    potongNama(temp.data.namaBarang, 24), 
                    temp.data.Kategori);
            temp = temp.next;
        }
        System.out.println("+-----+-------+--------------------------+----------------------+");
    }

    private String potongNama(String nama, int max) {
        if (nama.length() > max) return nama.substring(0, max - 3) + "...";
        return nama;
    }
}