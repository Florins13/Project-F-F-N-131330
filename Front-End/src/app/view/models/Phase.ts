import {GenericMatch} from "./GenericMatch";

export interface Phase {
  id: number;
  matches: GenericMatch[];
  status: String;
}
