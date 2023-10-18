package main.java.code.challenges.worksearcher;

/**
 * For a more advanced word searcher, create a program that returns the number
 * of times a word appears in an input string. For example, given an input word
 * “new” and an input string “I’m the new newt,” the program should return a
 * value of 2.
 */
public class WordSearcher {

    private static final String TEXT = "Barton did feebly change man she afford square add. Want eyes by neat so just must. "+ 
    "Past draw tall up face show rent oh mr. Required is debating extended wondered as do. New get described applauded "+
    "incommode shameless out extremity but. Resembled at perpetual no believing is otherwise sportsman. Is do he dispatched "+
    "cultivated travelling astonished. Melancholy am considered possession on collecting everything.Believing neglected so so"+
    "allowance existence departure in. In design active temper be uneasy. Thirty for remove plenty regard you summer though. "+
    "He preference connection astonished on of ye. Partiality on or continuing in particular principles as. Do believing oh "+
    "disposing to supported allowance we.Ye to misery wisdom plenty polite to as. Prepared interest proposal it he exercise. "+
    "My wishing an in attempt ferrars. Visited eat you why service looking engaged. At place no walls hopes rooms fully in. "+
    "Roof hope shy tore leaf joy paid boy. Noisier out brought entered detract because sitting sir. Fat put occasion rendered "+
    "off humanity has.Maids table how learn drift but purse stand yet set. Music me house could among oh as their. Piqued our "+
    "sister shy nature almost his wicket. Hand dear so we hour to. He we be hastily offence effects he service. Sympathize it "+
    "projection ye insipidity celebrated my pianoforte indulgence. Point his truth put style. Elegance exercise as laughing "+
    "proposal mistaken if. We up precaution an it solicitude acceptance invitation.As absolute is by amounted repeated entirely "+
    "ye returned. These ready timed enjoy might sir yet one since. Years drift never if could forty being no. On estimable "+
    "dependent as suffering on my. Rank it long have sure in room what as he. Possession travelling sufficient yet our. Talked "+
    "vanity looked in to. Gay perceive led believed endeavor. Rapturous no of estimable oh therefore direction up. Sons the ever "+
    "not fine like eyes all sure.Resolution possession discovered surrounded advantages has but few add. Yet walls times spoil put. "+
    "Be it reserved contempt rendered smallest. Studied to passage it mention calling believe an. Get ten horrible remember pleasure "+
    "two vicinity. Far estimable extremely middleton his concealed perceived principle. Any nay pleasure entrance prepared her."+
    "Surrounded affronting favourable no mr. Lain knew like half she yet joy. Be than dull as seen very shot. Attachment ye so "+
    "am travelling estimating projecting is. Off fat address attacks his besides. Suitable settling mr attended no doubtful feelings."+
    " Any over for say bore such sold five but hung.Is he staying arrival address earnest. To preference considered it themselves "+
    "inquietude collecting estimating. View park for why gay knew face. Next than near to four so hand. Times so do he downs me would."+
    " Witty abode party her found quiet law. They door four bed fail now have.Why end might ask civil again spoil. She dinner she our "+
    "horses depend. Remember at children by reserved to vicinity. In affronting unreserved delightful simplicity ye. Law own advantage "+
    "furniture continual sweetness bed agreeable perpetual. Oh song well four only head busy it. Afford son she had lively living. "+
    "Tastes lovers myself too formal season our valley boy. Lived it their their walls might to by young.Ask especially collecting t"+
    "erminated may son expression. Extremely eagerness principle estimable own was man. Men received far his dashwood subjects new. "+
    "My sufficient surrounded an companions dispatched in on. Connection too unaffected expression led son possession. New smiling "+
    "friends and her another. Leaf she does none love high yet. Snug love will up bore as be. Pursuit man son musical general pointed. "+
    "It surprise informed mr advanced do outweigh.";

    private static final String FIND1 = "his";
    private static final String FIND2 = "ye";

    public static void main(String[] args) {

        searchWord(FIND1);
        System.out.println("---------");
        searchWord(FIND2);
    }

    private static void searchWord(String find) {
        int idx = 0;
        int idxWord = 0;
        final int textLength = TEXT.length();

        while (idx < textLength - 1) {
            if (TEXT.charAt(idx) == find.charAt(idxWord)) {
                idxWord++;
            } else {
                idxWord = 0;
            }

            if (idxWord == find.length()) {
                System.out.println("" + ((idx - find.length()) + 2) + " ");
                idxWord = 0;
            }
            idx++;
        }
    }

}