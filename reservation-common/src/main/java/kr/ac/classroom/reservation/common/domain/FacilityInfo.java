package kr.ac.classroom.reservation.common.domain;

public record FacilityInfo(
        String classroomId,
        int outletCount,
        int chargeableSeatCount,
        boolean rentableCharger,
        boolean wheelchairAccessible,
        EquipmentStatus projectorStatus,
        EquipmentStatus pcStatus,
        String outletLocationDescription
) {
    public FacilityInfo {
        if (outletCount < 0 || chargeableSeatCount < 0) {
            throw new IllegalArgumentException("facility counts cannot be negative");
        }
    }
}
