package com.ctw.ffn131330.genericTournament;

import java.util.List;

public class PhasesDTO {

        private List<GenericMatch> matches;

        private PhaseStausEnum status;

        public PhasesDTO(List<GenericMatch> matches, PhaseStausEnum status) {
                this.matches = matches;
                this.status = status;
        }
}
