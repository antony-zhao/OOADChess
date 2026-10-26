package observers;

public class Context {
    private final boolean successfulMove, isCapture, isCheck, isCastle, isMate;
    private final String startLocation, endLocation;

    private Context(Builder builder) {
        this.successfulMove = builder.successfulMove;
        this.isCapture = builder.isCapture;
        this.isCheck = builder.isCheck;
        this.isCastle = builder.isCastle;
        this.isMate = builder.isMate;
        this.startLocation = builder.startLocation;
        this.endLocation = builder.endLocation;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String toString() {
        return endLocation + startLocation;
    }

    public static class Builder {
        private boolean successfulMove;
        private boolean isCapture;
        private boolean isCheck;
        private boolean isCastle;
        private boolean isMate;
        private String startLocation;
        private String endLocation;

        public Builder startLocation(String startLocation) {
            this.startLocation = startLocation;
            return this;
        }

        public Builder endLocation(String endLocation) {
            this.endLocation = endLocation;
            return this;
        }

        public Builder isCapture(boolean isCapture) {
            this.isCapture = isCapture;
            return this;
        }

        public Builder isCheck(boolean isCheck) {
            this.isCheck = isCheck;
            return this;
        }

        public Builder isCastle(boolean isCastle) {
            this.isCastle = isCastle;
            return this;
        }

        public Builder isMate(boolean isMate) {
            this.isMate = isMate;
            return this;
        }

        public Builder successfulMove(boolean successfulMove) {
            this.successfulMove = successfulMove;
            return this;
        }

        public Context build() {
            return new Context(this);
        }
    }
}
