package question2;
class Timer extends Thread
{
    private int seconds;

    Timer(int seconds){
        this.seconds = seconds;
    }

    public int getSeconds() {
        return seconds;
    }

    @Override
    public void run()
    {
        do {
            try {
                if(this.seconds > 0) {
                    this.seconds--;
                    Thread.sleep(1000);
                }else{
                    System.out.println("Timer has been finished!");
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }while(true);
    }
}