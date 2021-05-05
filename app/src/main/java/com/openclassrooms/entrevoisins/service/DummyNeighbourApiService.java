package com.openclassrooms.entrevoisins.service;

import com.openclassrooms.entrevoisins.di.DI;
import com.openclassrooms.entrevoisins.model.Neighbour;

import java.util.List;

/**
 * Dummy mock for the Api
 */
public class DummyNeighbourApiService implements NeighbourApiService {

    private List<Neighbour> neighbours = DummyNeighbourGenerator.generateNeighbours();


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Neighbour> getNeighbours() {
        return neighbours;
    }

    /**
     * We recover the id of the selected neighbour "neighbourId" and we compare his Id with Id of the list of neighbour
     * through "neighbour.getId()" for send the correct neighbour if both id are the same .
     * "neighbour.getId()" walks through the neighbors one by one to find the one we're on
     */
    @Override
    public Neighbour getNeighbourById(long neighbourId) {
        for (Neighbour neighbour : neighbours) {
            if (neighbour.getId() == neighbourId) {
                return neighbour;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNeighbour(Neighbour neighbour) {
        neighbours.remove(neighbour);
    }

    /**
     * {@inheritDoc}
     * @param neighbour
     */
    @Override
    public void addNeighbour(Neighbour neighbour) {
        neighbours.add(neighbour);
    }
}
