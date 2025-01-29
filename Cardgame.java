String[] cards = new String[2 * n];
int count = 0;
HashMap<String, Integer> h1 = new HashMap<>();
ArrayList<String> spades = new ArrayList<>();
ArrayList<String> diamonds = new ArrayList<>();
ArrayList<String> hearts = new ArrayList<>();
ArrayList<String> clubs = new ArrayList<>();
ArrayList<String> a1 = new ArrayList<>();

// Read and categorize the cards
for (int i = 0; i < 2 * n; i++) {
    cards[i] = sc.next();
    switch (cards[i].charAt(1)) {
        case 'C':
            clubs.add(cards[i]);
            break;
        case 'D':
            diamonds.add(cards[i]);
            break;
        case 'S':
            spades.add(cards[i]);
            break;
        case 'H':
            hearts.add(cards[i]);
            break;
    }
}

// Sort the categorized cards
Collections.sort(clubs);
Collections.sort(diamonds);
Collections.sort(spades);
Collections.sort(hearts);

// Process each suit's cards
processCards(clubs, ch, a1);
processCards(spades, ch, a1);
processCards(diamonds, ch, a1);
processCards(hearts, ch, a1);

// Check for the character condition and count impossible cases
if (!processRemainingCards(spades, ch, a1)) {
    count++;
} else if (!processRemainingCards(clubs, ch, a1)) {
    count++;
} else if (!processRemainingCards(diamonds, ch, a1)) {
    count++;
} else if (!processRemainingCards(hearts, ch, a1)) {
    count++;
}
if(ch=="S"){
    a1.addAll(spades);
}
if(ch=="C"){
    a1.addAll(clubs);
}
if(ch=="D"){
    a1.addAll(diamonds);
}

if(ch=="H"){
    a1.addAll(hearts);
}
// Output result
if (count > 0) {
    System.out.println("IMPOSSIBLE");
} else {
    int n1 = a1.size();
    int i = 0;
    int j = n1 - 1;
    while (j > i) {
          if((a1.get(i).charAt(1)!=a1.get(j).charAt(1))&&a1.get(j).substring(1)!=ch){
                      
          }
        System.out.println(a1.get(i) + " " + a1.get(j));
        i++;
        j--;
    }
}
}
sc.close();
}
public static void processCards(ArrayList<String> cards, String ch, ArrayList<String> s) {
if (cards.size() > 0 && !cards.get(0).substring(1).equals(ch)) {
if (cards.size() % 2 == 0) {
    for (int i = 0; i < cards.size(); i += 2) {
        System.out.println(cards.get(i) + " " + cards.get(i + 1));
        cards.remove(i);
        cards.remove(i+1);
        cards.size()-=2;

    }
} else {
    for (int i = 0; i < cards.size() - 1; i += 2) {
        System.out.println(cards.get(i) + " " + cards.get(i + 1));
    }
    s.add(cards.get(cards.size() - 1));
}
}
}
public static boolean processRemainingCards(ArrayList<String> cards, String ch, ArrayList<String> a1) {
if (cards.size() > 0 && cards.get(0).substring(1).equals(ch)) {
if (a1.size() > cards.size() || cards.size() % 2 != a1.size() % 2) {
    return false;
} else {
    a1.addAll(cards);
}
}
return true;
}