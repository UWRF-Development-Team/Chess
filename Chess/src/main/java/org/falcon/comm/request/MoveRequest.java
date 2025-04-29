package org.falcon.comm.request;

import lombok.Data;

@Data
public class MoveRequest {
    private int startRow;
    private int endRow;
    private int startCol;
    private int endCol;
}
