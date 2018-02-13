public class validPar {

    public boolean isValid(String s) {
        char[] charr = s.toCharArray();
        Stack<Character> myStack = new Stack<Character>();

        for(int i=0;i<charr.length;++i)
        {
            char c = charr[i];

            if(c == '(') myStack.push(')');

            else if(c == '{') myStack.push('}');

            else if(c == '[') myStack.push(']');

            else if(myStack.empty() || myStack.pop() != c )
            {
                return false;
            }
        }
        return myStack.empty();
    }
}
