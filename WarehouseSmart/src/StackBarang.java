public class StackBarang {

    private NodeBarang top;
    private int size = 0;

    public void push(NodeBarang barang) {
        if (barang == null) return;

        barang.next = top;
        top = barang;
        size++;

        System.out.println("Barang ditumpuk ke rak (STACK)!");
    }

    public NodeBarang pop() {
        if (top == null) {
            System.out.println("Rak kosong, tidak ada barang yang bisa diambil.");
            return null;
        }

        NodeBarang ambil = top;
        top = top.next;
        ambil.next = null;
        size--;

        return ambil;
    }

    public NodeBarang peek() {
        return top;
    }

    public void tampilStack() {
        if (top == null) {
            System.out.println("Rak masih kosong.");
            return;
        }

        System.out.println("\n=== DATA RAK BARANG (STACK) ===");

        NodeBarang temp = top;
        while (temp != null) {
            System.out.println("- " + temp.idBarang + " | " + temp.namaBarang + " | " + temp.Kategori);
            temp = temp.next;
        }
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int size() {
        return size;
    }
}
