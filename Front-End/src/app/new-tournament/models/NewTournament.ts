import {GenericMatch} from "../../view/models/GenericMatch";

export interface NewTournament {
  gameType: string;
  id: number;
  initialMatches: number;
  matches: GenericMatch[];
  tournamentNumberPhases: number;
}
