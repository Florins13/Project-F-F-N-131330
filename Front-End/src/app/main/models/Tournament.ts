import {GenericMatch} from "./GenericMatch";

export interface Tournament {
  gameType: string;
  id: number;
  initialMatches: number;
  tournament: Map<number, GenericMatch>;
}
