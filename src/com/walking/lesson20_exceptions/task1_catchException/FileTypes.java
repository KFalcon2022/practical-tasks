package Lesson20.Task1;

import java.util.*;

public enum FileTypes {
        TEXT(".txt"),
        VIDEO(".mp4", "avi", ".mkv"),
        AUDIO(".wav", ".mp3", ".ape"),
        PICTURE(".png", ".jpg");

        List <String> extension = new ArrayList<>();
        FileTypes(String... extensions)
        {
            for (String ext : extensions)
            this.extension.add(ext);
        }
        public String getExt(String userExt)
        {
            for (String str : extension)
                if (str.equals(userExt))
                    return str;
            throw new NoSuchElementException("нет подходящего расширения!");
        }
}

