package solution;


import model.*;

import java.util.List;
import java.util.TreeSet;

public class ProblemSolver {

    public Solution getSolution(InputData inputData) {

        List<Endpoint> endpoints = inputData.getEndpoints();

        TreeSet<Pair> crossJoin = new TreeSet<>();

        for (int endpoint = 0; endpoint < endpoints.size(); endpoint++) {
            Endpoint endpointInstance = endpoints.get(endpoint);
            for (int video = 0; video < endpointInstance.getRequestsToVideo().length; video++) {
                int videoRequests = endpointInstance.getRequestsToVideo()[video];
                for (int cache = 0; cache < endpointInstance.getCacheLatency().length; cache++) {
                    int cacheLatency = endpointInstance.getCacheLatency()[cache];
                    int value = (endpointInstance.getDataCenterLatency() - cacheLatency) * videoRequests;

                    crossJoin.add(new Pair(endpoint, cache, video, value));
                }
            }
        }

        crossJoin.iterator();
        for(Pair p : crossJoin){
            inputData.getCaches().get(p.cache).addVideo(inputData.getVideos().get(p.video));
        }

        return new Solution(inputData.getCaches());
    }
}
