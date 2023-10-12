package com.ctw.ffn131330.genericTournament;

import java.util.List;

public class PhasesDTO {

        private List<GenericMatch> matches;

        private PhaseStatusEnum status;

        public PhasesDTO(List<GenericMatch> matches, PhaseStatusEnum status) {
                this.matches = matches;
                this.status = status;
        }

        public PhasesDTO() {
        }

        public List<GenericMatch> getMatches() {
                return matches;
        }

        public void setMatches(List<GenericMatch> matches) {
                this.matches = matches;
        }

        public PhaseStatusEnum getStatus() {
                return status;
        }

        public void setStatus(PhaseStatusEnum status) {
                this.status = status;
        }


}
