package fr.ufc.l3info.oprog;

import java.util.HashMap;
import java.util.Set;


/**
 * Class representing a station.
 */
public class Station {

    private static class Pair{
        public int number;
        public double dist;

        public Pair(int number, double dist){
            this.number = number;
            this.dist = dist;
        }
    }

    private String name;
    private HashMap<String, Pair> lines;

    /** Builds a station associated to no lines.
     * @param _name the name of the station.
     */
    public Station(String _name) {
        this(_name, null, 0, -1.0);
    }

    /**
     * Builds a station, initially associated to a given line with a given number.
     * @param _name the name of the station
     * @param _line the name of the line associated to the station
     * @param _number the number of the station on the considered line
     * @param _dist the distance of the station on the considered line
     */
    public Station(String _name, String _line, int _number, double _dist) {
        name = _name;
        lines = new HashMap<String, Pair>();
        if(_line != null && !_line.isEmpty() && !_line.trim().isEmpty() && _number > 0 && _dist >= 0){
            lines.put(_line, new Pair(_number, _dist));
        }
    }


    /**
     * Adds a line to the current station, with the appropriate parameters.
     * If the line already exists, the previous information are overwritten.
     * @param _line the name of the line associated to the station
     * @param _number the number of the station on the considered line
     * @param _dist the distance of the station on the considered line
     */
    public void addLine(String _line, int _number, double _dist) {
        if (_line != null && !_line.isEmpty() && !_line.trim().isEmpty() && _number > 0 && _dist >= 0) {
            Pair p = new Pair(_number, _dist);
            if (!lines.containsKey(_line)) {
                lines.put(_line, p);
            } else {
                lines.replace(_line, p);
            }
        }
    }



    /**
     * Removes a line from the station.
     * @param _line the line to remove.
     */
    public void removeLine(String _line) {
        if(_line != null && !_line.trim().isEmpty()){
            lines.remove(_line.trim());
        }
    }


    /**
     * Retrieves the name of the station.
     * @return the name of the station
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the number of the station on a given line.
     * @param l The name of the line
     * @return the # of the station for the given line,
     *         or 0 if the line does not exist at the station.
     */
    public int getNumberForLine(String l) {
        if(l != null && lines.containsKey(l.trim())){
            return lines.get(l.trim()).number;
        }
        return 0;
    }


    /**
     * Returns the distance of the station on a given line.
     * @param l The name of the line.
     * @return the distance of the station w.r.t. the beginning of the line.
     */
    public double getDistanceForLine(String l) {
        if(l != null && lines.containsKey(l.trim())){
            return lines.get(l.trim()).dist;
        }
        return -1;
    }

    /**
     * Computes the set of lines associated to the station.
     * @return a set containing the names of the lines that cross the station.
     */
    public Set<String> getLines() {
        return lines.keySet();
    }


    @Override
    public int hashCode() {
        return name.length();
    }

    @Override
    public boolean equals(Object o) {
        if(o instanceof Station){
            return ((Station) o).name.equals(this.name);
        }
        return false;
    }
}