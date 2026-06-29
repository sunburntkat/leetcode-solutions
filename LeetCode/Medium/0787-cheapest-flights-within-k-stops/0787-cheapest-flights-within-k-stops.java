class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] flightsList = new ArrayList[n];
        for (int i = 0; i < flightsList.length; i++) {
            flightsList[i] = new ArrayList<>();
        }
        for (int i = 0; i < flights.length; i++) {
            flightsList[flights[i][0]].add(flights[i]);
        }
        PriorityQueue<Stop> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.price, b.price));
        int prices[] = new int[n];
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            prices[i] = Integer.MAX_VALUE;
            stops[i] = Integer.MAX_VALUE;
        }
        pq.offer(new Stop(src, -1, 0));
        while (!pq.isEmpty()) {
            Stop city = pq.poll();
            if(city.city==dst){
                return city.price;
            }
            for (int[] dest : flightsList[city.city]) {
                int price = city.price + dest[2];
                int cityStops=city.stops+1;
                if (prices[dest[1]] <= price && stops[dest[1]]<=cityStops) {
                    continue;
                }
                prices[dest[1]] = price;
                stops[dest[1]] = cityStops;
                if(city.stops==k){
                    continue;
                }
                pq.offer(new Stop(dest[1], cityStops, price));

            }
        }
        return -1;
    }
}

class Stop {
    int city;
    int stops;
    int price;

    public Stop(int city, int stops, int price) {
        this.city = city;
        this.stops = stops;
        this.price = price;
    }
}