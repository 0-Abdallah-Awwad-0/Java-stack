public class AlfredTest {
    //Starting point
    public static void main (String[] args){
        AlfredQuotes alfredBot = new AlfredQuotes();
        String testGreeting =alfredBot.basicGreeting();
        String testGuestGreeting = alfredBot.guestGreeting("AHMAD");
        String testDateAnnouncement = alfredBot.dateAnnouncement();
        String testRespondBeforAlexis = alfredBot.respondBeforAlexis("Alexis! Play some low-fi beats.");
        String alfredTest = alfredBot.respondBeforAlexis("I can't find my yo-yo. Maybe Alfred will know where it is.");
        String notRelevantTest = alfredBot.respondBeforAlexis("Maybe that's what Batman is about. Not winning. But failing.");
        //Printing Results
        System.out.println(testGreeting);
        System.out.println(testGuestGreeting);
        System.out.println(testDateAnnouncement);
        System.out.println(testRespondBeforAlexis);
        System.out.println(alfredTest);
        System.out.println(notRelevantTest);
    }
}