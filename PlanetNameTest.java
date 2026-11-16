public class PlanetNameTest {
    public static void main(String[] args) {
        testPlanetCanBeNamed();
        testPlanetCanBeRenamedWithoutAddingAnotherEntry();
        System.out.println("All Planet naming tests passed.");
    }

    private static void testPlanetCanBeNamed() {
        resetPlanetRegistry();

        Planet planet = new Planet();
        planet.name.set("Kerbin");

        assertEquals("Kerbin", planet.name.get(), "planet name");
        assertEquals(0, planet.name.getID(), "planet ID");
        assertEquals(1, Planet.Objects.size(), "number of registered planets");
        assertEquals("Kerbin", Planet.Objects.get(0), "registered planet name");
    }

    private static void testPlanetCanBeRenamedWithoutAddingAnotherEntry() {
        resetPlanetRegistry();

        Planet planet = new Planet();
        planet.name.set("Kerbin");
        int originalId = planet.name.getID();

        planet.name.set("Kerbin Prime");

        assertEquals("Kerbin Prime", planet.name.get(), "renamed planet name");
        assertEquals(originalId, planet.name.getID(), "planet ID after rename");
        assertEquals(1, Planet.Objects.size(), "number of registered planets after rename");
        assertEquals("Kerbin Prime", Planet.Objects.get(originalId), "registered name after rename");
    }

    private static void resetPlanetRegistry() {
        Planet.Objects.clear();
        Planet.IDs.clear();
        Planet.nextFreeID = 0;
        Planet.prev_selected = null;
    }

    private static void assertEquals(Object expected, Object actual, String description) {
        if (!expected.equals(actual)) {
            throw new AssertionError(description + ": expected <" + expected + "> but was <" + actual + ">");
        }
    }
}
