package Basic;

class ReverseString {
    public static void main(String[] args) {
        String name = "This is my name";
        StringBuilder reversed = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            reversed.append(name.charAt(name.length() - 1 - i));
        }

        System.out.println(reversed);
    }
}