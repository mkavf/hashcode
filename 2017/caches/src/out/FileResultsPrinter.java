package out;


import model.Cache;
import model.Solution;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FileResultsPrinter {

    public void printResults(Solution solution, String fileName){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            writer.append(String.valueOf(solution.getUsedCaches())).append('\n');
            List<Cache> caches = solution.filledCaches;
            for (int i = 0; i < caches.size(); i++){
                if (caches.get(i).getVideos().isEmpty()){
                    continue;
                }
                writer.append(String.valueOf(i))
                        .append(' ').
                        append(printVideos(caches.get(i).getVideos()))
                        .append('\n');
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String printVideos(Set<Integer> videos) {
        return videos.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

}
