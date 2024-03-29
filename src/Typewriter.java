public class Typewriter {

    private final int delay;

    public Typewriter(int delay) {
        this.delay = delay;
    }

    public void type(String message)  {

      try{
          for (char c : message.toCharArray()) {
              System.out.print(c);
              Thread.sleep(delay);
          }
          System.out.println();  // Move to the next line after typing the complete message

      }catch (InterruptedException ie){
          System.out.println(message);
      }

    }

}
