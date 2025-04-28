public class DoublyLinkedList {

    // Node Class'ı
    private class Node {
        private CustomerInfo musteri;
        private Node next;
        private Node previous;

        public Node(CustomerInfo musteri, Node next, Node previous) {
            this.musteri = musteri;
            this.next = next;
            this.previous = previous;
        }

    }
    //--------------------------------------------------------------------------\\

    private Node head = null;
    private Node tail = null;

    // Soyada göre sıralı ekleme yapan method
    public void add(CustomerInfo customerInfo) {
        if (isEmpty()) {
            head = tail = new Node(customerInfo, null, null);
            return;
        }

        Node position = head;
        while (position != null) {
            if (customerInfo.getSoyad().compareTo(position.musteri.getSoyad()) > 0) {
                position = position.next;
            }
            else if (customerInfo.getSoyad().compareTo(position.musteri.getSoyad()) == 0) {
                if (customerInfo.getAdSoyad().compareTo(position.musteri.getAdSoyad()) > 0) {
                    position = position.next;
                }
                else {
                    if (position == head) {
                        Node yeniMusteri = new Node(customerInfo, head, null);
                        head.previous = yeniMusteri;
                        head = yeniMusteri;
                        return;
                    }
                    else {
                        Node yeniMusteri = new Node(customerInfo, position, position.previous);
                        position.previous.next = yeniMusteri;
                        position.previous = yeniMusteri;
                        return;
                    }
                }

            }
            else {
                if (position == head) {
                    Node yeniMusteri = new Node(customerInfo, head, null);
                    head.previous = yeniMusteri;
                    head = yeniMusteri;
                    return;
                }
                else {
                   Node yeniMusteri = new Node(customerInfo, position, position.previous);
                   position.previous.next = yeniMusteri;
                   position.previous = yeniMusteri;
                   return;
                }
            }

        }
        Node yeniMusteri = new Node(customerInfo, null, tail);
        tail.next = yeniMusteri;
        tail = yeniMusteri;
    }

    // Müşteri arayıp bilgilerini yazdıran method
    public void musteriYazdir(String adSoyad) {
        Node position = head;
        while (position != null) {
            if (adSoyad.equalsIgnoreCase(position.musteri.getAdSoyad())) {
                System.out.println(position.musteri);
                return;
            }
            else {
                position = position.next;
            }
        }
        System.out.println("Müşteri bulunamadı...");
    }

    // Müşteri arayıp listeden silme yapan method.
    public void remove(String adSoyad) {
        if (head == tail && head.musteri.getAdSoyad().equalsIgnoreCase(adSoyad)) {
            head = tail = null;
            return;
        }
        Node position = head;
        while (position != null) {
            if (adSoyad.equalsIgnoreCase(position.musteri.getAdSoyad())) {
                if (position == head) {
                    head = head.next;
                    head.previous = null;
                    return;
                }
                else if (position == tail) {
                    tail = tail.previous;
                    tail.next = null;
                    return;
                }
                else {
                    position.previous.next = position.next;
                    position.next.previous = position.previous;
                    return;
                }
            }
            else {
                position = position.next;
            }
        }
    }

    // Listeyi baştan sona yazdıran method
    public void AdanZyeYazdir() {
        Node position = head;
        while (position != null) {
            System.out.println(position.musteri);
            position = position.next;
        }
    }

    // Listeyi sondan başa yazdıran method
    public void ZdenAyaYazdir() {
        Node position = tail;
        while (position != null) {
            System.out.println(position.musteri);
            position = position.previous;
        }
    }

    // isEmpty methodu
    public boolean isEmpty() {
        return head == null;
    }
}