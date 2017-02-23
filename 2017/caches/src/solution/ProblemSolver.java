package solution;


import model.Endpoint;
import model.InputData;
import model.Pair;
import model.Solution;

import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class ProblemSolver {

    public Solution getSolution(InputData inputData) {
        Set<Integer> usedVides = new HashSet<>();


        List<Endpoint> endpoints = inputData.getEndpoints();

        PriorityQueue<Pair> crossJoin = new PriorityQueue<>();

        System.out.println("Processing");
        for (int endpoint = 0; endpoint < endpoints.size(); endpoint++) {
            Endpoint endpointInstance = endpoints.get(endpoint);
            for (int video = 0; video < endpointInstance.getRequestsToVideo().length; video++) {
                int videoRequests = endpointInstance.getRequestsToVideo()[video];
                for (int cache = 0; cache < endpointInstance.getCacheLatency().length; cache++) {
                    int cacheLatency = endpointInstance.getCacheLatency()[cache];
                    if (cacheLatency == 0 || videoRequests == 0 || usedVides.contains(video)){
                        continue;
                    }
                    int value = (endpointInstance.getDataCenterLatency() - cacheLatency) * videoRequests;

                    Pair p = new Pair(endpoint, cache, video, value);
                    crossJoin.add(p);
                    usedVides.add(video);
                }
            }
        }

        System.out.println("Processing 2");
        for(Pair p : crossJoin){
            inputData.getCaches().get(p.cache).addVideo(inputData.getVideos().get(p.video));
        }

        System.out.println("Result");
        return new Solution(inputData.getCaches());
    }
}
