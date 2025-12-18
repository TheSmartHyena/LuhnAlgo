boolean luhn(String txt) {
    ArrayList<Integer> list = new ArrayList<>();

    // Cast to int
    for (char c : txt.toCharArray()) {
        list.add(Integer.parseInt(String.valueOf(c)));
    }

    // Double it, if necessary -9
    int start = list.size() % 2 == 0 ? 0 : 1;
    for (int i = start; i < list.size(); i+=2) {
        int doubled = list.get(i) * 2;
        list.set(i, doubled > 9 ? doubled - 9 : doubled);
    }

    // Return the sum % 10
    return list.stream().reduce(0, Integer::sum) % 10 == 0;
}

void main() {
    String test = "4012001037141112";
    System.out.println(luhn(test));
}
