export interface GenericMatch{
  id: number;
  matchNumber: number;
  playerOne: string | null | undefined;
  playerTwo: string | null | undefined;
  resultOne: number;
  resultTwo: number;
  complete: boolean;
}
