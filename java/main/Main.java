package main;

import ball.Ball;
import decorate.*;
import exception.NeznaykaException;
import org.apache.logging.log4j.LogManager;
import people.*;
import type.Material;
import type.Profession;

import java.io.PrintStream;
import java.util.Random;
import org.apache.logging.log4j.Logger;
import java.io.OutputStream;

// вариант 123347
public class Main {

    private static final Logger logger = LogManager.getLogger(Main.class);

    private static Object Place;

    public static void main(String[] args) {
        // Перенаправляем стандартный вывод в лог
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) {
                logger.info(String.valueOf((char) b));  // Логируем информацию
            }

            @Override
            public void write(byte[] b, int off, int len) {
                logger.info(new String(b, off, len));  // Логируем информацию
            }
        }));
        location.Place GreenCity = null;

        Neznayka neznayka = new Neznayka(
                "Незнайка",
                "мужчина",
                0.2F,
                "Оранжевый костюм",
                GreenCity,
                Profession.SLACKER);

        Ball ball = new Ball(
                "бал");

        Tent tent = new Tent(
                "палатки",
                0.25F,
                Material.FABRIC);

        Rope rope = new Rope("верёвочки", 0.05F, Material.SYNTHETICS);

        Light light = new Light(
                "фонарики",
                0.2F,
                Material.METAL);

        Flag flag = new Flag(
                "флажки",
                0.03F,
                Material.FABRIC);

        Tree tree = new Tree(
                "деревья",
                0.65F,
                Material.WOODEN);

        Random random = new Random();
        int probability = 50;
        boolean eventHappened = random.nextInt(100) < probability;

        if (eventHappened) {
            ball.chanceStateForRain();
            tent.chanceStateForRain();
            rope.chanceStateForRain();
            light.chanceStateForRain();
            flag.chanceStateForRain();
            tree.chanceStateForRain();
        }

        logger.info(neznayka.getName() + neznayka.getOut() + " и всё повторялось снова");
        logger.info(neznayka.getName() + neznayka.say(" Не буду больше вылезать! Надо быть твёрдым. Буду твёрдо сидеть здесь хоть до завтрашнего дня. Вылезу, только когда бал начнётся"));
        try {
            neznayka.hide();
        } catch (NeznaykaException e) {
            logger.error(e.getMessage());
        }
        logger.info("На следующий день " + ball.toString());
        if (eventHappened) {
            logger.info(tent.toString() + " насквозь");
        } else {
            logger.info(tent.toString() + " словно пряничные избушки");
        }
        if (eventHappened) {
            logger.info(rope.toString() + " из-за ветра");
        }
          else {
            logger.info(rope.toString() + " над площадкой");
        }
        logger.info(light.toString());
        logger.info(flag.toString());
          if (eventHappened) {
              logger.info(tree.toString() + " и некрасивые");
        }
          else {
              logger.info(tree.toString() + " словно новогодняя ёлка");
        }
          try {
              neznayka.hide();
        }
          catch (NeznaykaException e) {
              logger.info(e.getMessage());
        }
    }
}
