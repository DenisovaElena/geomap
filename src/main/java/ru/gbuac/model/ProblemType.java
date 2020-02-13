package ru.gbuac.model;

public enum ProblemType {
    addressIssues,
    addressIssuesNoAddress,
    addressIssuesIncomplete,
    addressIssuesInvalid,

    landReg,
    landRegInactive,
    landRegInactiveUnOwnership,
    landRegBuildAtNotFormedLand,

    selfWilled,
    selfWilledBuildDocMismatch,

    misuse,
    misuseSignMismatch,

    squatting,
    squattingFencesOutsideLandBoundaries,
    squattingBuildOnUnpresLand,
    squattingBuildWithoutRights,

    timeExcess,
    inappMaintenance
}
