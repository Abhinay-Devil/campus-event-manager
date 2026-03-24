import { useEffect, useState } from "react";
import {
  Card,
  CardContent,
  Typography,
  Grid,
  Box,
  Button,
  CircularProgress,
  List,
  ListItem,
  ListItemText,
  Chip,
} from "@mui/material";
import { Event as EventIcon, CheckCircle as CheckCircleIcon } from "@mui/icons-material";
import DashboardLayout from "../../components/layout/DashboardLayout";
import API from "../../api/axios";

const StudentDashboard = () => {
  const [events, setEvents] = useState([]);
  const [registeredEvents, setRegisteredEvents] = useState([]);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    fetchEvents();
    fetchRegisteredEvents();
  }, []);

  const fetchEvents = () => {
    API.get("/events")
      .then((res) => {
        setEvents(res.data.content || res.data);
      })
      .catch(console.error);
  };

  const fetchRegisteredEvents = () => {
    API.get("/events/my-registrations")
      .then((res) => {
        setRegisteredEvents(res.data);
        setLoading(false);
      })
      .catch((err) => {
        console.error(err);
        setLoading(false);
      });
  };

  const handleRegister = (eventId) => {
    API.post(`/events/${eventId}/register`)
      .then(() => {
        fetchRegisteredEvents();
        fetchEvents();
      })
      .catch(console.error);
  };

  const handleCancel = (eventId) => {
    API.delete(`/events/${eventId}/register`)
      .then(() => {
        fetchRegisteredEvents();
        fetchEvents();
      })
      .catch(console.error);
  };

  const isRegistered = (eventId) => {
    return registeredEvents.some((reg) => reg.event.id === eventId);
  };

  if (loading) {
    return (
      <DashboardLayout>
        <Box display="flex" justifyContent="center" alignItems="center" minHeight="400px">
          <CircularProgress />
        </Box>
      </DashboardLayout>
    );
  }

  return (
    <DashboardLayout>
      <Typography variant="h4" component="h1" gutterBottom>
        Student Dashboard
      </Typography>

      <Grid container spacing={3}>
        <Grid item xs={12} md={6}>
          <Card>
            <CardContent>
              <Typography variant="h6" component="h2" gutterBottom>
                Available Events
              </Typography>
              <List>
                {events.map((event) => (
                  <ListItem key={event.id} divider>
                    <Box flexGrow={1}>
                      <Box display="flex" alignItems="center" mb={1}>
                        <EventIcon sx={{ mr: 1 }} />
                        <Typography variant="subtitle1">{event.title}</Typography>
                        {isRegistered(event.id) && (
                          <Chip
                            label="Registered"
                            color="success"
                            size="small"
                            icon={<CheckCircleIcon />}
                            sx={{ ml: 1 }}
                          />
                        )}
                      </Box>
                      <Typography variant="body2" color="text.secondary">
                        {event.date} at {event.time} - {event.location}
                      </Typography>
                      <Typography variant="body2">
                        Capacity: {event.currentRegistrations}/{event.capacity}
                      </Typography>
                    </Box>
                    <Box>
                      {isRegistered(event.id) ? (
                        <Button
                          variant="outlined"
                          color="error"
                          onClick={() => handleCancel(event.id)}
                        >
                          Cancel
                        </Button>
                      ) : (
                        <Button
                          variant="contained"
                          onClick={() => handleRegister(event.id)}
                          disabled={event.currentRegistrations >= event.capacity}
                        >
                          Register
                        </Button>
                      )}
                    </Box>
                  </ListItem>
                ))}
              </List>
            </CardContent>
          </Card>
        </Grid>

        <Grid item xs={12} md={6}>
          <Card>
            <CardContent>
              <Typography variant="h6" component="h2" gutterBottom>
                My Registrations
              </Typography>
              <List>
                {registeredEvents.map((registration) => (
                  <ListItem key={registration.id}>
                    <EventIcon sx={{ mr: 2 }} />
                    <ListItemText
                      primary={registration.event.title}
                      secondary={`${registration.event.date} at ${registration.event.time}`}
                    />
                  </ListItem>
                ))}
              </List>
            </CardContent>
          </Card>
        </Grid>
      </Grid>
    </DashboardLayout>
  );
};

export default StudentDashboard;