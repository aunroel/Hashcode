public class UberMain {

    public static void main(String[] args) {
        FileReader fr = new FileReader();

//        fr.readFile("a_example.in");
        fr.readFile("b_should_be_easy.in");
        fr.parseData();
    }
}
