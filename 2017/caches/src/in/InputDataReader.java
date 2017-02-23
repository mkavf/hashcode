package in;


import model.Cache;
import model.Endpoint;
import model.InputData;
import model.Video;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Comparator;

public class InputDataReader {

    public InputData readData(String filePath){
        InputData inputData = new InputData();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line = br.readLine();
            String[] inputParams = line.split(" ");
            inputData.setVideoNumber(Integer.valueOf(inputParams[0]));
            inputData.setEndpointNumber(Integer.valueOf(inputParams[1]));
            inputData.setRequestNumber(Integer.valueOf(inputParams[2]));
            inputData.setCacheNumber(Integer.valueOf(inputParams[3]));
            inputData.setCacheSize(Integer.valueOf(inputParams[4]));

            for (int i = 0; i < inputData.getCacheNumber(); i++) {
                inputData.getCaches().add(new Cache(i, inputData.getCacheSize()));
            }

            line = br.readLine();
            String[] videoSizes = line.split(" ");
            int index = 0;
            for (String videoSize : videoSizes) {
                inputData.getVideos().add(new Video(Integer.valueOf(videoSize), index++));
            }

            inputData.setMinVideoSize(inputData.getVideos().stream().min(Comparator.comparing(Video::getSize)).get().getSize());

            for (int i = 0; i < inputData.getEndpointNumber(); i++) {
                line = br.readLine();
                String[] endPointParams = line.split(" ");

                Endpoint endpoint = new Endpoint(inputData.getVideoNumber(), inputData.getCacheNumber());
                endpoint.setDataCenterLatency(Integer.valueOf(endPointParams[0]));

                for (int j = 0; j < Integer.valueOf(endPointParams[1]); j++) {
                    line = br.readLine();
                    String[] latency = line.split(" ");
                    endpoint.getCacheLatency()[Integer.valueOf(latency[0])] = Integer.valueOf(latency[1]);
                    inputData.getCaches().get(Integer.valueOf(latency[0])).addEndpoint(i);
                }

                inputData.getEndpoints().add(endpoint);
            }

            line = br.readLine();

            while (line != null) {
                String[] requests = line.split(" ");
                inputData.getEndpoints().get(Integer.valueOf(requests[1])).getRequestsToVideo()[Integer.valueOf(requests[0])] = Integer.valueOf(requests[2]);
                line = br.readLine();
            }
        } catch (Exception e) {
             e.printStackTrace();
        }
        return inputData;
    }
}



/*

        5 2 4 3 100
        50 50 80 30 110
        1000 3
        0 100
        2 200
        1 300
        500 0
        3 0 1500
        0 1 1000
        4 0 500
        1 0 1000
        5 videos, 2 endpoints, 4 request descriptions, 3 caches 100MB each.
        Videos 0, 1, 2, 3, 4 have sizes 50MB, 50MB, 80MB, 30MB, 110MB.
        Endpoint 0 has 1000ms datacenter latency and is connected to 3 caches:
        The latency (of endpoint 0) to cache 0 is 100ms.
        The latency (of endpoint 0) to cache 2 is 200ms.
        The latency (of endpoint 0) to cache 1 is 200ms.
        Endpoint 1 has 500ms datacenter latency and is not connected to a cache.
        1500 requests for video 3 coming from endpoint 0.
        1000 requests for video 0 coming from endpoint 1.
        500 requests for video 4 coming from endpoint 0.
        1000 requests for video 1 coming from endpoint 0.
*/
