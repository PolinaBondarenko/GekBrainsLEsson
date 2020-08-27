import java.awt.*;
import java.time.LocalDateTime;

public class BackGround{

public void setBackGround(GameCanvas canvas) {
    LocalDateTime time = LocalDateTime.now();
    int seconds = time.getSecond();
    switch (seconds) {
        case 0: canvas.setBackground(Color.YELLOW);
        break;
        case 10: canvas.setBackground(Color.BLACK);
        break;
        case 20: canvas.setBackground(Color.CYAN);
        break;
        case 30: canvas.setBackground(Color.ORANGE);
        break;
        case 40: canvas.setBackground(Color.BLUE);
        break;
        case 50: canvas.setBackground(Color.GRAY);
    }
    if (seconds > 30) canvas.setBackground(Color.CYAN);
    else if(seconds > 20) canvas.setBackground(Color.ORANGE);
    else if (seconds > 10) canvas.setBackground(Color.BLUE);
}

}