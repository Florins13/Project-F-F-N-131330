import { GenericMatch } from "./GenericMatch";
import { Phase } from "./Phase";

export interface Tournament {
  gameType: string;
  id: number;
  initialMatches: number;
  matchesAsList: [GenericMatch[]];
  totalMatches: number;
  phases: Phase[];
}
