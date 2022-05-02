class Solution {
    public int swimInWater(int[][] grid) {
        
        int n = grid.length;
        
        PriorityQueue<State> pq = new PriorityQueue<>(new Comparator<State>() {
           public int compare(State o1, State o2) {
               return o1.max - o2.max;
           } 
        });
        pq.add(new State(0, 0, grid[0][0]));
        
        List<State> explored = new LinkedList<>();
        
        while (!pq.isEmpty()) {
            State s = pq.remove();
            explored.add(s);
            if (s.row == n - 1 && s.col == n - 1) {
                return s.max;
            }
            if (s.row < n - 1) {
                int newRow = s.row + 1;
                int newCol = s.col;
                State newState = new State(newRow, newCol, Math.max(s.max, grid[newRow][newCol]));
                if (!pq.contains(newState) && !explored.contains(newState)) pq.add(newState);
            }
            if (s.row > 0) {
                int newRow = s.row - 1;
                int newCol = s.col;
                State newState = new State(newRow, newCol, Math.max(s.max, grid[newRow][newCol]));
                if (!pq.contains(newState) && !explored.contains(newState)) pq.add(newState);
            }
            if (s.col < n - 1) {
                int newRow = s.row;
                int newCol = s.col + 1;
                State newState = new State(newRow, newCol, Math.max(s.max, grid[newRow][newCol]));
                if (!pq.contains(newState) && !explored.contains(newState)) pq.add(newState);
            }
            if (s.col > 0) {
                int newRow = s.row;
                int newCol = s.col - 1;
                State newState = new State(newRow, newCol, Math.max(s.max, grid[newRow][newCol]));
                if (!pq.contains(newState) && !explored.contains(newState)) pq.add(newState);
            }
        }
        return -1;
        
    }
    
    class State {
        State(int row, int col, int max) {
            this.row = row;
            this.col = col;
            this.max = max;
        }
        public boolean equals(Object o) {
            State oState = (State) o;
            return this.row == oState.row && this.col == oState.col;
        }
        int row;
        int col;
        int max;
    }
    
}
