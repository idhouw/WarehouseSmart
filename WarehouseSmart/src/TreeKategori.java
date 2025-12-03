public class TreeKategori {
    NodeBarang root;

    // Insert node ke BST berdasarkan kategori
    public NodeBarang insert(NodeBarang root, NodeBarang baru) {
        if (root == null) return baru;

        if (baru.Kategori.compareToIgnoreCase(root.Kategori) < 0) {
            root.left = insert(root.left, baru);
        } else {
            root.right = insert(root.right, baru);
        }
        return root;
    }

    // Tambah kategori beserta data barangnya
    public void tambahKategori(NodeBarang barang) {
        root = insert(root, barang);
        System.out.println("Barang ditambahkan ke Tree kategori.");
    }

    // INORDER = A-Z
    public void inorder(NodeBarang root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root.Kategori + " | " + root.namaBarang + " | " + root.idBarang);
            inorder(root.right);
        }
    }

    // PREORDER
    public void preorder(NodeBarang root) {
        if (root != null) {
            System.out.println(root.Kategori + " | " + root.namaBarang);
            preorder(root.left);
            preorder(root.right);
        }
    }

    // POSTORDER
    public void postorder(NodeBarang root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.Kategori + " | " + root.namaBarang);
        }
    }

    // Searching berdasarkan kategori
    public NodeBarang searchKategori(String Kategori) {
        NodeBarang temp = root;

        while (temp != null) {
            if (Kategori.equalsIgnoreCase(temp.Kategori)) {
                return temp;
            } 
            else if (Kategori.compareToIgnoreCase(temp.Kategori) < 0) {
                temp = temp.left;
            } 
            else {
                temp = temp.right;
            }
        }
        return null;
    }
}

