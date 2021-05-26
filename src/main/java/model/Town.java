package model;

import static util.ErrorConstants.INVALID_NAME_ERROR;

public class Town {

    public String name;
    public int id;

    public Town(String name) throws Exception {
        if (name.length() == 1 && Character.isLetter(name.charAt(0))){
            this.name = name;
        } else {
            throw new Exception(INVALID_NAME_ERROR);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        final Town other = (Town) obj;
        return other.name.equals(name);
    }

    @Override
    public String toString(){
        return "Town " + name;
    }

}
