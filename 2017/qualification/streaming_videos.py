# reading first line of input
num_of_videos, num_of_endpoints, num_of_req_desc, num_of_caches, cache_size = map(int, raw_input().split())

# reading second line of input
videos_sizes = map(int, raw_input().split())

latencies_improvement = {}
requests_to_video = {}

# reading endpoints configuration
for endpoint in range(num_of_endpoints):
    lat_to_dc, caches = map(int, raw_input().split())

    latencies_improvement[endpoint] = {}
    for j in range(caches):
        cache, latency = map(int, raw_input().split())
        latencies_improvement[endpoint][cache] = lat_to_dc - latency

# reading videos configuration
for req in range(num_of_req_desc):
    video, endpoint, num_of_requests = map(int, raw_input().split())

    if endpoint not in requests_to_video:
        requests_to_video[endpoint] = {}
    requests_to_video[endpoint][video] = num_of_requests


# calculating improvement scores
scores = []
for endpoint in latencies_improvement.keys():
    for cache in latencies_improvement[endpoint].keys():
        for video in requests_to_video[endpoint].keys():
                score = latencies_improvement[endpoint][cache] * requests_to_video[endpoint][video]
                scores.append((endpoint, cache, video, score))

# sorting improvement scores
scores.sort(key=lambda x: x[3], reverse=True)

# filling up caches
used_caches = {}
endpoints_with_videos = {}

for score in scores:
    endpoint = score[0]
    cache = score[1]
    video = score[2]

    if endpoint not in endpoints_with_videos:
        endpoints_with_videos[endpoint] = {}

    if video in endpoints_with_videos[endpoint]:
        continue

    if cache not in used_caches:
        used_caches[cache] = [cache_size, []]
    video_size = videos_sizes[video]
    current_cache_size = used_caches[cache][0]
    if current_cache_size - video_size > 0 \
            and video not in used_caches[cache][1]:
        used_caches[cache][0] -= video_size
        used_caches[cache][1].append(video)
        endpoints_with_videos[endpoint][video] = True


# printing output
print len(used_caches)

for cache in used_caches.keys():
    print str(cache) + ' ' + ' '.join([str(x) for x in used_caches[cache][1]])

# end
