public class revWordsString {

    public String wordRev(String s)
    {
        String[] words =  s.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        for(int i=0;i<words.length;i++)
        {
            sb.insert(0,words[i]);
            if(i<words.length){
                sb.insert(0," ");
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        String s = "the sky is blue";
        revWordsString rs =  new revWordsString();
        String res = rs.wordRev(s);
        System.out.println(res);
    }
}
