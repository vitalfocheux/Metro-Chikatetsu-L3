package fr.ufc.l3info.oprog;

import java.util.*;

public class Network {

    public HashSet<Station> stations;
    public HashSet<String> lines;

    public Network(){
        stations = new HashSet<>();
        lines = new HashSet<>();
    }
    public void addStation(Station s){
        for(Station st : stations){
            if(s.equals(st)){
                return;
            }
        }
        stations.add(s);
        lines.addAll(s.getLines());
    }

    public Set<String> getLines(){
        for(Station st : stations) {
            lines.addAll(st.getLines());
        }
        return lines;
    }
    public Station getStationByName(String name){
        for(Station s : stations){
            if(s.getName().equals(name)){
                return s;
            }
        }
        return null;
    }
    public Station getStationByLineAndNumber(String line, int number) {
        for (Station s : stations) {
            if (s.getNumberForLine(line) != 0 && s.getNumberForLine(line) == number) {
                return s;
            }
        }
        return null;
    }

    private boolean isConnect(Map<String, Set<Station>> mapLines){
        Set<Station> visited = new HashSet<>();
        Stack<Station> aVisite = new Stack<>();
        aVisite.add(stations.iterator().next());
        while(!aVisite.isEmpty()){
            Station courant = aVisite.pop();
            if(visited.contains(courant)){
                continue;
            }
            visited.add(courant);
            Set<String> linesStation = courant.getLines();
            for(String _line : linesStation){
                Set<Station> stationsLine = mapLines.get(_line);
                for(Station s : stationsLine){
                    if(!visited.contains(s)){
                        aVisite.add(s);
                    }
                }
            }
        }

        return visited.size() == stations.size();
    }

    public boolean isValid(){
        for(Station st : stations) {
            lines.addAll(st.getLines());
        }
        if(stations.isEmpty() || lines.isEmpty()){
            return false;
        }

        Map<String, Set<Station>> mapLines = new HashMap<>();
        Set<String> linesStations;
        Set<Station> stationsLine;

        for(Station s : stations){
            linesStations = s.getLines();
            for(String line : linesStations){
                stationsLine = mapLines.get(line);
                if(stationsLine == null){
                    mapLines.put(line, new HashSet<Station>());
                    stationsLine = mapLines.get(line);
                }
                stationsLine.add(s);
            }
        }

        for(String line : lines){
            Set<Station> st = mapLines.get(line);
            int size = st.size();
            double l_dist = -1.0;
            for(int i = 1; i <= size; ++i){
                boolean trouve = false;
                for(Station s : st){
                    if(s.getNumberForLine(line) == i){
                        if(s.getNumberForLine(line) == 1 && s.getDistanceForLine(line) != 0.0){
                            return false;
                        }
                        double dist = s.getDistanceForLine(line);
                        if(dist <= l_dist){
                            return false;
                        }
                        l_dist = dist;
                        trouve = true;
                        break;
                    }
                }
                if(!trouve){
                    return false;
                }
            }
        }
        return isConnect(mapLines);
    }
    public double distance(String s1, String s2){
        if(getStationByName(s1) == null || getStationByName(s2) == null || s1 == null || s2 == null || !this.isValid()){
            return -1.0; // Si les stations ne sont pas valides ou l'algorithme n'a pas pu être exécuté, retourne -1
        }

        if(s1.equals(s2)){
            return 0.0;
        }
        Station fin = getStationByName(s2);

        Map<Station, Double> distances = new HashMap<>();
        for(Station s : stations){
            distances.put(s, Double.MAX_VALUE);
        }
        distances.put(getStationByName(s1), 0.0);

        Set<Station> visited = new HashSet<>();
        while(!visited.contains(fin)){
            Station courant = null;
            double minDist = Double.MAX_VALUE;
            for(Station s : stations){
                if(!visited.contains(s) && distances.get(s) < minDist){
                    courant = s;
                    minDist = distances.get(s);
                }
            }

            visited.add(courant);
            Set<String> linesStation = courant.getLines();
            for(String l : linesStation){
                for(Station voisin : stations){
                    if(!voisin.getLines().contains(l)){
                        continue;
                    }
                    int nbCourant = courant.getNumberForLine(l);
                    int nbVoisin = voisin.getNumberForLine(l);
                    if(nbCourant == nbVoisin - 1 || nbCourant == nbVoisin + 1){
                        double dist = distances.get(courant) + Math.abs(courant.getDistanceForLine(l) - voisin.getDistanceForLine(l));
                        if(dist < distances.get(voisin)){
                            distances.put(voisin, dist);
                        }
                    }
                }
            }
        }
        return distances.get(fin);
    }

}